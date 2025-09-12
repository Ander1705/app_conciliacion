const FormSection = ({ title, children, className = '' }) => {
  return (
    <div className={`form-section ${className}`}>
      {title && (
        <h3 className="text-lg font-semibold text-university-blue mb-4 border-b border-gray-200 pb-2">
          {title}
        </h3>
      )}
      {children}
    </div>
  )
}

export default FormSection