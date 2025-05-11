module.exports = {
  content: [
    './*.html',
    './js/**/*.js'
  ],
  theme: {
    extend: {
      colors: {
        primary: 'var(--color-primary)',
        secondary: 'var(--color-secondary)',
        neutral: 'var(--color-neutral)',
      }
    }
  },
  plugins: [],
}
