const MultiSelect = ({ label, options, values = {}, onChange, error, required = false }) => {
  const handleToggle = (key) => {
    onChange(key, !values[key])
  }

  return (
    <div style={{marginBottom: '1rem'}}>
      <label style={{
        display: 'block', 
        fontSize: '0.875rem', 
        fontWeight: '500', 
        color: '#374151', 
        marginBottom: '0.5rem'
      }}>
        {label} {required && <span style={{color: '#ef4444'}}>*</span>}
      </label>
      
      <div style={{display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(150px, 1fr))', gap: '1rem'}}>
        {options.map((option) => (
          <button
            key={option.key}
            type="button"
            onClick={() => handleToggle(option.key)}
            style={{
              padding: '1rem',
              border: '2px solid #e5e7eb',
              borderRadius: '8px',
              backgroundColor: values[option.key] ? 'var(--primary-color)' : 'white',
              color: values[option.key] ? 'white' : '#374151',
              cursor: 'pointer',
              transition: 'all 0.2s',
              textAlign: 'center',
              fontSize: '0.875rem',
              fontWeight: '500'
            }}
          >
            <div style={{marginBottom: '0.5rem', fontSize: '1rem', fontWeight: '600'}}>
              {option.label}
            </div>
            <div style={{fontSize: '0.75rem', opacity: 0.8}}>
              {option.description}
            </div>
          </button>
        ))}
      </div>
      
      {error && (
        <p style={{color: '#ef4444', fontSize: '0.875rem', marginTop: '0.5rem'}}>
          {error}
        </p>
      )}
    </div>
  )
}

export default MultiSelect