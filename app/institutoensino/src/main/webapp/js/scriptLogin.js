document.addEventListener("DOMContentLoaded", function() {
    const togglePassword = document.querySelector("#togglePassword");
    const passwordField = document.querySelector("#password");

    // Adiciona o evento de clique ao ícone de olho
    togglePassword.addEventListener('click', function () {
        const type = passwordField.getAttribute('type') === 'password' ? 'text' : 'password';
        passwordField.setAttribute('type', type);

        // Mudar ícone
        this.classList.toggle("fa-eye");
        this.classList.toggle('fa-eye-slash');
    });

    // Gerenciar a exibição da mensagem de erro
    setTimeout(() => {
        const errorMessage = document.querySelector('.error-message');
        if (errorMessage) {
            errorMessage.classList.add('hide');
            // Reativar o evento de clique no ícone
            togglePassword.removeAttribute('disabled'); // Ativa o botão
        }
    }, 5000);
});
