document.querySelector('button[type="submit"]').addEventListener('click', function (event) {
    const email = document.querySelector('#email').value;
    const confirmEmail = document.querySelector('#confirm-email').value;
    const password = document.querySelector('#password').value;
    const confirmPassword = document.querySelector('#confirm-password').value;

    let valid = true; // Flag para checar se o formulário é válido

    // Limpar mensagens de erro
    const errorMessages = document.querySelectorAll('.error-message');
    errorMessages.forEach(msg => {
        msg.classList.remove('visible'); // Remove a classe visível
        msg.style.height = '0'; // Define a altura para 0
        msg.style.opacity = '0'; // Torna invisível
        msg.style.visibility = 'hidden'; // Torna invisível
    });

    // Validação dos e-mails
    if (email !== confirmEmail) {
        const errorMsg = document.getElementById("confirm-email-error");
        errorMsg.textContent = 'Os e-mails não coincidem.';

        // Define a altura correta e visibilidade
        errorMsg.style.visibility = 'visible';
        errorMsg.style.opacity = '1';
        errorMsg.style.height = 'auto'; // Ajusta para a altura automática

        // Espera o navegador calcular a altura antes de aplicar
        const height = errorMsg.offsetHeight;
        errorMsg.style.height = `${height}px`; // Define a altura para o valor calculado

        document.getElementById("confirm-email-group").scrollIntoView({behavior: "smooth"});
        valid = false;

        // Adiciona o efeito de desvanecimento após 5 segundos
        setTimeout(() => {
            errorMsg.style.height = '0'; // Define a altura para 0
            errorMsg.style.opacity = '0'; // Torna invisível
            errorMsg.style.visibility = 'hidden'; // Torna invisível
        }, 5000);
    }

    // Validação das senhas
    if (password !== confirmPassword) {
        const errorMsg = document.getElementById("confirm-password-error");
        errorMsg.textContent = 'As senhas não coincidem.';

        // Define a altura correta e visibilidade
        errorMsg.style.visibility = 'visible';
        errorMsg.style.opacity = '1';
        errorMsg.style.height = 'auto'; // Ajusta para a altura automática

        // Espera o navegador calcular a altura antes de aplicar
        const height = errorMsg.offsetHeight;
        errorMsg.style.height = `${height}px`; // Define a altura para o valor calculado

        document.getElementById("confirm-password-group").scrollIntoView({behavior: "smooth"});
        valid = false;

        // Adiciona o efeito de desvanecimento após 5 segundos
        setTimeout(() => {
            errorMsg.style.height = '0'; // Define a altura para 0
            errorMsg.style.opacity = '0'; // Torna invisível
            errorMsg.style.visibility = 'hidden'; // Torna invisível
        }, 5000);
    }

    // Previne o envio do formulário se houver erros
    if (!valid) {
        event.preventDefault();
    }
});

function formatRG(input) {
    // Remove todos os caracteres não numéricos
    let value = input.value.replace(/\D/g, '');

    // Adiciona o formato: 00.000.000-0
    if (value.length > 2) {
        value = value.replace(/(\d{2})(\d)/, '$1.$2');
    }
    if (value.length > 5) {
        value = value.replace(/(\d{2}\.\d{3})(\d)/, '$1.$2');
    }
    if (value.length > 8) {
        value = value.replace(/(\d{2}\.\d{3}\.\d{3})(\d)/, '$1-$2');
    }
    input.value = value;
}

function formatCPF(input) {
    // Remove todos os caracteres não numéricos
    let value = input.value.replace(/\D/g, '');

    // Adiciona o formato: 000.000.000-00
    if (value.length > 3) {
        value = value.replace(/(\d{3})(\d)/, '$1.$2');
    }
    if (value.length > 6) {
        value = value.replace(/(\d{3}\.\d{3})(\d)/, '$1.$2');
    }
    if (value.length > 9) {
        value = value.replace(/(\d{3}\.\d{3})(\d{2})/, '$1-$2');
    }
    input.value = value;
}

