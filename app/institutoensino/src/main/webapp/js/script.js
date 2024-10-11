// script.js

// Alternar visibilidade da senha
const togglePassword = document.querySelector('#togglePassword');
const passwordField = document.querySelector('#password');

togglePassword.addEventListener('click', function () {
    const type = passwordField.getAttribute('type') === 'password' ? 'text' : 'password';
    passwordField.setAttribute('type', type);

    // Mudar ícone
    this.classList.toggle('fa-eye-slash');
});

// Exemplo de desvanecimento após 5 segundos
setTimeout(() => {
    const errorMessage = document.querySelector('.error-message');
    if (errorMessage) {
        errorMessage.classList.add('hide');
    }
}, 5000);
