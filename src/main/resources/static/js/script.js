document.addEventListener("DOMContentLoaded", function() {
    const themeToggleButton = document.getElementById("theme_change_button");
    const themeText = document.getElementById("theme_button_text");

    // Function to toggle the theme
    function toggleTheme() {
        const currentTheme = document.documentElement.classList.contains("dark") ? "dark" : "light";
        
        if (currentTheme === "dark") {
            document.documentElement.classList.remove("dark");
            document.body.classList.remove("dark");
            localStorage.setItem("theme", "light");
            themeText.textContent = "Dark";
        } else {
            document.documentElement.classList.add("dark");
            document.body.classList.remove("dark");
            localStorage.setItem("theme", "dark");
            themeText.textContent = "Light";
        }
    }

    // Set initial theme based on local storage
    if (localStorage.getItem("theme") === "dark") {
        document.documentElement.classList.add("dark");
        document.body.classList.add("dark");
        themeText.textContent = "Dark";
    }

    // Add event listener for theme toggle button
    themeToggleButton.addEventListener("click", toggleTheme);
});
