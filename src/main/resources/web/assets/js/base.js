window.addEventListener("load", function () {
    var currentPage = window.location.pathname;

    document.querySelector("a[href='" + currentPage + "']").className += " is-active";
});