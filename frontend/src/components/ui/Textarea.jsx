import { forwardRef } from 'react'

const Textarea = forwardRef(({ 
  label, 
  error, 
  required, 
  rows = 4, 
  className = '', 
  maxLength,
  showCharacterCount = false,
  value = '',
  ...props 
}, ref) => {
  const currentLength = value?.length || 0
  const isOverLimit = maxLength && currentLength > maxLength
  const isNearLimit = maxLength && currentLength >= maxLength * 0.8

  return (
    <div className="textarea-container">
      {label && (
        <label style={{
          display: 'block',
          fontSize: '0.875rem',
          fontWeight: '600',
          color: '#1f2937',
          marginBottom: '0.25rem'
        }}>
          {label}
          {required && <span style={{color: '#dc2626', marginLeft: '0.25rem', fontWeight: '600'}}>*</span>}
        </label>
      )}
      
      <div className="textarea-wrapper">
        <textarea
          ref={ref}
          rows={rows}
          value={value}
          className={`form-textarea ${error ? 'textarea-error' : ''} ${className}`}
          {...props}
        />
        
        {(showCharacterCount || maxLength) && (
          <div style={{
            textAlign: 'right', 
            fontSize: '0.75rem', 
            color: isOverLimit ? '#dc2626' : '#6b7280',
            marginTop: '0.25rem',
            fontWeight: isOverLimit ? '600' : '500'
          }}>
            {currentLength}{maxLength && `/${maxLength}`} caracteres
            {isOverLimit && <span style={{color: '#dc2626', marginLeft: '0.5rem'}}>⚠️ Límite excedido</span>}
          </div>
        )}
      </div>
      
      {error && (
        <p className="textarea-error-message">{error}</p>
      )}
    </div>
  )
})

Textarea.displayName = 'Textarea'

export default Textarea