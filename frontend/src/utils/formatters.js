// Formateadores de fecha y texto para el sistema de conciliación

export const formatDateToSpanish = (date = new Date()) => {
  const months = [
    'enero', 'febrero', 'marzo', 'abril', 'mayo', 'junio',
    'julio', 'agosto', 'septiembre', 'octubre', 'noviembre', 'diciembre'
  ];
  
  const day = date.getDate();
  const month = months[date.getMonth()];
  const year = date.getFullYear();
  
  return `${day} de ${month} de ${year}`;
};

export const generateCityAndDate = () => {
  const spanishDate = formatDateToSpanish();
  return `Bogotá D.C., ${spanishDate}`;
};

export const formatCedula = (cedula) => {
  if (!cedula) return '';
  return cedula.toString().replace(/\B(?=(\d{3})+(?!\d))/g, '.');
};

export const formatCurrency = (amount) => {
  if (!amount) return '';
  return new Intl.NumberFormat('es-CO', {
    style: 'currency',
    currency: 'COP',
    minimumFractionDigits: 0
  }).format(amount);
};