const RadioGroup = ({ label, name, options, value, onChange, error, required = false }) => {
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
      
      <div style={{display: 'flex', gap: '1rem', flexWrap: 'wrap'}}>
        {options.map((option) => (
          <label key={option.value} style={{
            display: 'flex', 
            alignItems: 'center', 
            cursor: 'pointer',
            padding: '0.5rem 1rem',
            border: '2px solid #e5e7eb',
            borderRadius: '8px',
            backgroundColor: value === option.value ? 'var(--primary-color)' : 'white',
            color: value === option.value ? 'white' : '#374151',
            transition: 'all 0.2s'
          }}>
            <input
              type="radio"
              name={name}
              value={option.value}
              checked={value === option.value}
              onChange={(e) => onChange(e.target.value)}
              style={{display: 'none'}}
            />
            <span style={{fontSize: '0.875rem'}}>{option.label}</span>
          </label>
        ))}
      </div>
      
      {error && (
        <p style={{color: '#ef4444', fontSize: '0.875rem', marginTop: '0.25rem'}}>
          {error}
        </p>
      )}
    </div>
  )
}

export default RadioGroup