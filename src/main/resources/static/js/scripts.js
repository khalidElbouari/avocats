const body = document.querySelector("body");
const darkLight = document.querySelector("#darkLight");
const sidebar = document.querySelector(".sidebar");
const cardContainer = document.querySelector(".card-container");
const submenuItems = document.querySelectorAll(".submenu_item");
const sidebarOpen = document.querySelector("#sidebarOpen");
const sidebarClose = document.querySelector(".collapse_sidebar");
const sidebarExpand = document.querySelector(".expand_sidebar");
const headerHeight = document.querySelector(".navbar").offsetHeight; // Get the height of the header

sidebarOpen.addEventListener("click", () => {
    sidebar.classList.toggle("close");
    adjustCardMargin();
});

sidebarClose.addEventListener("click", () => {
    sidebar.classList.add("close", "hoverable");
    adjustCardMargin();
});

sidebarExpand.addEventListener("click", () => {
    sidebar.classList.remove("close", "hoverable");
    adjustCardMargin();
});

sidebar.addEventListener("mouseenter", () => {
    if (sidebar.classList.contains("hoverable")) {
        sidebar.classList.remove("close");
    }
});
sidebar.addEventListener("mouseleave", () => {
    if (sidebar.classList.contains("hoverable")) {
        sidebar.classList.add("close");
    }
});

darkLight.addEventListener("click", () => {
    body.classList.toggle("dark");
    if (body.classList.contains("dark")) {
        document.setI;
        darkLight.classList.replace("bx-sun", "bx-moon");
    } else {
        darkLight.classList.replace("bx-moon", "bx-sun");
    }
});

submenuItems.forEach((item, index) => {
    item.addEventListener("click", () => {
        item.classList.toggle("show_submenu");
        submenuItems.forEach((item2, index2) => {
            if (index !== index2) {
                item2.classList.remove("show_submenu");
            }
        });
    });
});

// Function to adjust the margin of the card container
function adjustCardMargin() {
    const sidebarWidth = sidebar.classList.contains("close") ? 80 : 280; // Get the width of the sidebar
    cardContainer.style.marginLeft = sidebarWidth + "px"; // Set the margin of the card container equal to the width of the sidebar
    cardContainer.style.marginTop = headerHeight + 20 + "px"; // Add a bit of space between the header and the cards
}

// Initial adjustment of the card margin based on the initial state of the sidebar
adjustCardMargin();

// Adjust card margin when the window is resized
window.addEventListener("resize", adjustCardMargin);
