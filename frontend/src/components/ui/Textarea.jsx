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
        <label className="textarea-label">
          {label}
          {required && <span className="required-indicator">*</span>}
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
          <div className={`character-counter ${isOverLimit ? 'counter-over' : isNearLimit ? 'counter-near' : 'counter-normal'}`}>
            <div className="counter-info">
              <span className="counter-current">{currentLength}</span>
              {maxLength && (
                <>
                  <span className="counter-separator">/</span>
                  <span className="counter-max">{maxLength}</span>
                </>
              )}
              <span className="counter-label"> caracteres</span>
            </div>
            {isOverLimit && (
              <div className="counter-warning">
                <span className="warning-icon">⚠️</span>
                <span className="warning-text">Límite excedido</span>
              </div>
            )}
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