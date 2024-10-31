document.querySelector('button[type="submit"]').addEventListener('click', async function (event) {
    const email = document.querySelector('#email').value;
    const confirmEmail = document.querySelector('#confirm-email').value;
    const password = document.querySelector('#password').value;
    const confirmPassword = document.querySelector('#confirm-password').value;

    let valid = true;

    // Limpar mensagens de erro
    const errorMessages = document.querySelectorAll('.error-message');
    errorMessages.forEach(msg => {
        msg.classList.remove('visible');
        msg.style.opacity = '0';
        msg.style.visibility = 'hidden';
        msg.textContent = '';
    });

    // Validação dos e-mails
    const emailErrorMsg = document.getElementById("email-error");

    if (email !== confirmEmail) {
        emailErrorMsg.textContent = 'Os e-mails não coincidem.';
        emailErrorMsg.style.visibility = 'visible';
        emailErrorMsg.style.opacity = '1';
        document.getElementById("email-group").scrollIntoView({ behavior: "smooth" });
        valid = false;
    } else {
        // Verificar se o e-mail já está registrado
        try {
            const response = await fetch(`/cadastro?email=${encodeURIComponent(email)}`);
            const data = await response.json();
            if (data.emailExiste) {
                emailErrorMsg.textContent = 'Este e-mail já está registrado.';
                emailErrorMsg.style.visibility = 'visible';
                emailErrorMsg.style.opacity = '1';
                document.getElementById("email-group").scrollIntoView({ behavior: "smooth" });
                valid = false;
            }
        } catch (error) {
            console.error('Erro ao verificar e-mail:', error);
        }
    }

    // Validação das senhas
    if (password !== confirmPassword) {
        const passwordErrorMsg = document.getElementById("confirm-password-error");
        passwordErrorMsg.textContent = 'As senhas não coincidem.';
        passwordErrorMsg.style.visibility = 'visible';
        passwordErrorMsg.style.opacity = '1';
        document.getElementById("confirm-password-group").scrollIntoView({ behavior: "smooth" });
        valid = false;
    }

    if (!valid) {
        event.preventDefault();
    }
});



document.addEventListener("DOMContentLoaded", function () {
    const serverErrorMessage = document.getElementById("server-error-message");

    // Verifica se há mensagem de erro do servidor
    if (serverErrorMessage && serverErrorMessage.textContent.trim() !== "") {
        serverErrorMessage.style.visibility = 'visible';
        serverErrorMessage.style.opacity = '1';

        // Define um timeout para ocultar a mensagem após 5 segundos
        setTimeout(() => {
            serverErrorMessage.style.opacity = '0'; // Torna invisível
            serverErrorMessage.style.visibility = 'hidden'; // Torna invisível
            serverErrorMessage.textContent = ''; // Limpa o texto para liberar espaço
        }, 5000);
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

