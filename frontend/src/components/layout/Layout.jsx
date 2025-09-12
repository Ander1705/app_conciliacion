import Header from './Header'

const Layout = ({ children }) => {
  return (
    <div style={{minHeight: '100vh', backgroundColor: '#f9fafb'}}>
      <Header />
      <main style={{maxWidth: '64rem', margin: '0 auto', padding: '1rem 1rem 1.5rem 1rem'}}>
        {children}
      </main>
    </div>
  )
}

export default Layout