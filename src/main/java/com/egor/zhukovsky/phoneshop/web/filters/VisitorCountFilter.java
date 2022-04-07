package com.egor.zhukovsky.phoneshop.web.filters;

import com.egor.zhukovsky.phoneshop.model.statistic.VisitorsStatistic;
import com.egor.zhukovsky.phoneshop.security.DosProtectionService;
import com.egor.zhukovsky.phoneshop.security.impl.DosProtectionServiceImpl;
import com.egor.zhukovsky.phoneshop.service.VisitorsStatisticService;
import com.egor.zhukovsky.phoneshop.service.impl.VisitorsStatisticServiceImpl;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class VisitorCountFilter implements Filter {

    private VisitorsStatisticService visitorsStatisticService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        visitorsStatisticService = VisitorsStatisticServiceImpl.getInstance();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        VisitorsStatistic visitorsStatistic = visitorsStatisticService.getVisitorsStatisticByDate(LocalDate.now());
        if (visitorsStatistic == null){
            visitorsStatistic = new VisitorsStatistic();
            visitorsStatistic.setDate(LocalDate.now());
            visitorsStatistic.setVisitorsCount(1L);
            visitorsStatisticService.saveVisitorStatistic(visitorsStatistic);
        } else {
            visitorsStatistic.setVisitorsCount(visitorsStatistic.getVisitorsCount()+1);
            visitorsStatisticService.updateVisitorStatistic(visitorsStatistic);
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
    }
}