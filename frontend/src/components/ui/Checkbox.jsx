import { forwardRef } from 'react'

const Checkbox = forwardRef(({ label, error, className = '', ...props }, ref) => {
  return (
    <div className="mb-4">
      <div className="flex items-center">
        <input
          ref={ref}
          type="checkbox"
          className={`form-checkbox ${error ? 'border-red-500 focus:ring-red-500' : ''} ${className}`}
          {...props}
        />
        {label && (
          <label className="ml-2 text-sm text-gray-700">
            {label}
          </label>
        )}
      </div>
      {error && (
        <p className="mt-1 text-sm text-red-600">{error}</p>
      )}
    </div>
  )
})

Checkbox.displayName = 'Checkbox'

export default Checkbox