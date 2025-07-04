/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/main/resources/templates/**/*.html", "./src/**/*.js"],
  darkMode: "class", // ✅ this is correct
  theme: {
    extend: {},
  },
  plugins: [],
}
