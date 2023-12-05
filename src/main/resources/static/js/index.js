document.getElementById("btn-account").addEventListener("click",
    function () {
        var accountMenu = document.getElementById("account-menu");
        accountMenu.classList.toggle("show-menu")
    }
);


/*******************************8*************************************************/
const formContainer = document.getElementById("homeSearchForm");

function clearButtonStyles() {
    let buttons = document.querySelectorAll(".home-carousel-button");

    buttons.forEach(function (button) {
        button.style.boxShadow = "";
    });
}

function initializeDateRangePicker() {
    $('input[name="daterange"]').daterangepicker(
        {
            opens: "left",
        },
        function (start, end, label) {
            console.log(
                "A new date selection was made: " +
                start.format("YYYY-MM-DD") +
                " to " +
                end.format("YYYY-MM-DD")
            );
            // You can add additional logic here based on the selected date range
        }
    );
}

initializeDateRangePicker();

function handleHotelButtonClick() {
    let btn = document.getElementsByClassName("home-carousel-button")[0];
    var formContainer = document.getElementById("homeSearchForm");
    // formContainer.innerHTML = "";
    formContainer.innerHTML = `
        <!-- Bên trái của form -->
        <div class="container d-flex flex-column gap-3 h-100 w-100">
          <div class="input-group flex-nowrap">
            <span class="input-group-text" id="addon-wrapping">
                <span class="material-symbols-outlined text-danger">
                    location_on
                 </span>
            </span>
            <input type="text" class="form-control" placeholder="Enter destination (E.g: Ha Long )" aria-describedby="addon-wrapping"/>
          </div>

          <div class="input-group">
            <span class="input-group-text">
              <span class="material-symbols-outlined text-danger">
                payments
              </span>
            </span>
            <input
             
              type="number"
              class="form-control"
              placeholder="Min price"
              min="1"
            />
            <input type="number" class="form-control" placeholder="Max price" />
          </div>

          <div class="container p-0 d-flex flex-row gap-4">
            <div class="input-group flex-nowrap">
              <span class="input-group-text" id="addon-wrapping"
                ><span class="material-symbols-outlined text-danger">
                  person
                </span></span
              >
              <input
                type="number"
                class="form-control"
                placeholder="Number of adults"
              />
            </div>

            <div class="input-group flex-nowrap">
              <span class="input-group-text" id="addon-wrapping"
                ><span class="material-symbols-outlined text-danger">
                  person
                </span></span
              >
              <input
                type="number"
                class="form-control"
                placeholder="Number of child"
              />
            </div>
          </div>
        </div>
        <!-- Bên trái của form -->

        <!-- Bên phải của form -->
        <div
          class="container w-75 h-100 d-flex flex-column justify-content-between align-items-end"
        >
          <div class="input-group flex-nowrap">
            <span class="input-group-text" id="addon-wrapping"
              ><span class="material-symbols-outlined text-danger">
                <span class="material-symbols-outlined text-danger">
                  date_range
                </span>
              </span></span
            >
            <input
              class="form-control"
              type="text"
              name="daterange"
              placeholder="01/01/2018 - 01/15/2018"
              value=""
            />
          </div>

          <button
            type="submit"
            class="btn btn-danger w-75 d-flex align-items-center justify-content-center"
          >
            Search &nbsp;
            <span class="material-symbols-outlined"> travel_explore </span>
          </button>
        </div>`;

    clearButtonStyles();
    btn.style.boxShadow = "0 0 20px #eee";
    initializeDateRangePicker();
}

// handleHotelButtonClick();

function handleTourButtonClick() {
    let btn = document.getElementsByClassName("home-carousel-button")[1];
    var formContainer = document.getElementById("homeSearchForm");
    // formContainer.innerHTML = "";
    formContainer.innerHTML = `
        <!-- Bên trái của form -->
        <div class="container d-flex flex-column gap-3 h-100 w-100">
          <div class="input-group flex-nowrap">
            <span class="input-group-text" id="addon-wrapping">
                <span class="material-symbols-outlined text-danger">location_on</span>
            </span>
            <input
              id="destination"
              aria-describedby="addon-wrapping"
              class="form-control"
              placeholder="Enter destination (E.g: Ha Long )"
              type="text"
            />
          </div>

          <div class="input-group">
            <span class="input-group-text">
              <span class="material-symbols-outlined text-danger">
                payments
              </span>
            </span>
            <input id="minPrice" class="form-control" min="1" placeholder="Min price" type="number"/>
            <input id="maxPrice" class="form-control" placeholder="Max price" type="number" />
          </div>

          <div class="container p-0 d-flex flex-row gap-4">
            <div class="input-group flex-nowrap">
              <span class="input-group-text" id="addon-wrapping"
                ><span class="material-symbols-outlined text-danger">
                  globe
                </span></span
              >
              <select id="typeTour" class="form-select">
                <option selected value="domestic">Domestic</option>
                <option value="international">International</option>
              </select>
            </div>

            <div class="input-group flex-nowrap">
              <span class="input-group-text" id="addon-wrapping">
                <span class="material-symbols-outlined text-danger">explore</span>
               </span>
              <select id="category" class="form-select">
                <option class="text-secondary" selected>Categories</option>
                <option value="health">Health</option>
                <option value="cultural">Cultural</option>
                <option value="religious ">Religious</option>
                <option value="sport">Sport</option>
              </select>
            </div>
          </div>
        </div>
        <!-- Bên trái của form -->

        <!-- Bên phải của form -->
        <div
          class="container w-75 h-100 d-flex flex-column justify-content-between align-items-end"
        >
          <div class="input-group flex-nowrap">
            <span class="input-group-text" id="addon-wrapping">
                <span class="material-symbols-outlined text-danger">
                    <span class="material-symbols-outlined text-danger"> date_range</span>
                </span>
            </span >
            <input
              class="form-control"
              name="daterange"
              placeholder="01/01/2018 - 01/15/2018"
              type="text"
              value=""
            />
          </div>

          <button onclick="search()" id="searchBtn" 
            class="btn btn-danger w-75 d-flex align-items-center justify-content-center" >
            Search &nbsp;
            <span class="material-symbols-outlined"> travel_explore </span>
          </button>
        </div>`;

    clearButtonStyles();
    btn.style.boxShadow = "0 0 20px #eee";
    initializeDateRangePicker();
}

/***********Blogs Navbar************/
document.addEventListener("DOMContentLoaded", function () {
    var navbar = document.getElementById("blogsNavbar");
    var links = navbar.getElementsByTagName("a");

    for (var i = 0; i < links.length; i++) {
        links[i].addEventListener("click", function (event) {
            var targetId = event.target.getAttribute("href").substring(1); // Get the target div's id without the '#'

            // Remove the "active" class from all links
            for (var j = 0; j < links.length; j++) {
                links[j].classList.remove("active");
            }

            // Add the "active" class to the clicked link
            event.target.classList.add("active");

            // Handle the "All" link separately
            if (targetId === "postScrollspyHeading1") {
                var allDivs = document.querySelectorAll(
                    "[id^='postScrollspyBox']"
                );
                for (var k = 0; k < allDivs.length; k++) {
                    allDivs[k].classList.remove("d-none");
                }
            } else {
                // Hide other divs based on the clicked link
                var allDivs = document.querySelectorAll(
                    "[id^='postScrollspyBox']"
                );
                for (var k = 0; k < allDivs.length; k++) {
                    if (allDivs[k].id === targetId) {
                        allDivs[k].classList.remove("d-none");
                    } else {
                        allDivs[k].classList.add("d-none");
                    }
                }
            }
        });
    }
});

// blogsNavbar
document.addEventListener("DOMContentLoaded", function () {
    var navbar = document.getElementById("blogsNavbar");
    var links = navbar.getElementsByTagName("a");

    for (var i = 0; i < links.length; i++) {
        links[i].addEventListener("click", function (event) {
            var targetId = event.target.getAttribute("href").substring(1); // Get the target div's id without the '#'

            // Remove the "active" class from all links
            for (var j = 0; j < links.length; j++) {
                links[j].classList.remove("active");
            }

            // Add the "active" class to the clicked link
            event.target.classList.add("active");

            // Handle the "All" link separately
            if (targetId === "postScrollspyHeading1") {
                var allDivs = document.querySelectorAll(
                    "[id^='postScrollspyBox']"
                );
                for (var k = 0; k < allDivs.length; k++) {
                    allDivs[k].classList.remove("d-none");
                }
            } else {
                // Hide other divs based on the clicked link
                var allDivs = document.querySelectorAll(
                    "[id^='postScrollspyBox']"
                );
                for (var k = 0; k < allDivs.length; k++) {
                    if (allDivs[k].id === targetId) {
                        allDivs[k].classList.remove("d-none");
                    } else {
                        allDivs[k].classList.add("d-none");
                    }
                }
            }
        });
    }
});


function search() {
    const searchObj = {
        destination: "",
        minPrice: "",
        maxPrice: "",
        typeTour: "",
        category: "",
    }

    const destination = document.getElementById("destination")
    const minPrice = document.getElementById("minPrice")
    const maxPrice = document.getElementById("maxPrice")
    const typeTour = document.getElementById("typeTour")
    const category = document.getElementById("category")

    searchObj.destination = destination.value;
    searchObj.minPrice = minPrice.value;
    searchObj.maxPrice = maxPrice.value;
    searchObj.typeTour = typeTour.value;
    searchObj.category = category.value;


    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/tour/search',
        data: JSON.stringify(searchObj),
        contentType: 'application/json',
    }).done((response) => {


        location.href = `/tour/tourName=${response}`
    }).fail((err) => {
        console.error((err))
    })
}


$(function () {
    $('input[name="daterange"]').daterangepicker(
        {
            opens: "left",
        },
        function (start, end, label) {
            console.log(
                "A new date selection was made: " +
                start.format("YYYY-MM-DD") +
                " to " +
                end.format("YYYY-MM-DD")
            );
        }
    );
});



