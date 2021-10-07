var span = document.getElementsByClassName('span')[0];
var file = "Carga una imagen";                
span.innerHTML = file;

const fileInput = document.getElementById('imagenRepresentativa');

fileInput.onchange = () => {
  const selectedFile = fileInput.files[0];
  span.innerHTML = fileInput.files[0].name;
  console.log(selectedFile);
};