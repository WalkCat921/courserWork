var map = L.map('map').setView([53.901902, 27.557126], 12);
//
L.tileLayer('https://api.mapbox.com/directions/v5/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}', {
    attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
    maxZoom: 18,
    id: 'mapbox',
    tileSize: 512,
    zoomOffset: -1,
    accessToken: 'pk.eyJ1Ijoid2Fsa2NhdCIsImEiOiJjbDFjbmtuM3AwMjFiM2puM3psYTc0d3E4In0.YpCwjWGNeCtrwgVZLo6Tvw'
}).addTo(map);

mapboxgl.accessToken = 'pk.eyJ1Ijoid2Fsa2NhdCIsImEiOiJjbDFjbmJwZjEwOTl1M2pucnduYXE4Z3l4In0.Ga8aiMk9F22XO0i1VOvwBQ';
const map = new mapboxgl.Map({
    container: 'map',
    style: 'mapbox://styles/mapbox/streets-v11',
    center: [-122.662323, 45.523751], // starting position
    zoom: 12
});
// set the bounds of the map
const bounds = [
    [-123.069003, 45.395273],
    [-122.303707, 45.612333]
];
map.setMaxBounds(bounds);

// an arbitrary start will always be the same
// only the end or destination will change
const start = [-122.662323, 45.523751];

// this is where the code for the next step will go

var marker = L.marker([53.850770, 27.476452],
    {alt: 'PS #1'}).addTo(map)
    .bindPopup('Phone Shop #1');
var marker = L.marker([53.898079, 27.554528],
    {alt: 'PS #2'}).addTo(map)
    .bindPopup('Phone Shop #2');
var marker = L.marker([53.875562, 27.464746],
    {alt: 'PS #3'}).addTo(map)
    .bindPopup('Phone Shop #2');

$('select').on('change', function() {
    alert( this.value );
});