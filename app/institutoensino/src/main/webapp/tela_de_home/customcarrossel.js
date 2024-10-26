// to get current year
function getYear() {
    var currentDate = new Date();
    var currentYear = currentDate.getFullYear();
    document.querySelector("#displayYear").innerHTML = currentYear;
}

getYear();

//  course section owl carousel

$(".course_owl-carousel").owlCarousel({
    autoplay: true,
    loop: true,
    margin: 5,
    autoHeight: true,
    nav: true,
    navText: ['<i class="bx bx-chevron-left prev"></i>', '<i class="bx bx-chevron-right next"></i>'], // Atualize aqui
    autoWidth: true
});



/** google_map js **/

function myMap() {
    var mapProp = {
        center: new google.maps.LatLng(40.712775, -74.005973),
        zoom: 18,
    };
    var map = new google.maps.Map(document.getElementById("googleMap"), mapProp);
}