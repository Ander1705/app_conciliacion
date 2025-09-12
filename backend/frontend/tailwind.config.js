/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      colors: {
        'ucmc-blue': '#003366',
        'ucmc-gold': '#FFD700',
        'ucmc-light-blue': '#E6F3FF',
        'ucmc-dark-blue': '#001A33',
      },
      fontFamily: {
        'sans': ['Inter', 'system-ui', 'sans-serif'],
      },
    },
  },
  plugins: [],
}