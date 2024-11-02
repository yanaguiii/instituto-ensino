    document.addEventListener("DOMContentLoaded", function () {
        const form = document.querySelector("form");

        form.addEventListener("submit", function (event) {
            const email = document.getElementById("email").value;
            const confirmEmail = document.getElementById("confirm-email").value;
            const password = document.getElementById("password").value;
            const confirmPassword = document.getElementById("confirm-password").value;
            let isValid = true;

            // Limpa mensagens de erro anteriores
            document.getElementById("email-error").textContent = "";
            document.getElementById("password-error").textContent = "";

            // Verifica se os emails coincidem
            if (email !== confirmEmail) {
                const errorMsgEmail = document.getElementById("email-error");
                errorMsgEmail.textContent = 'Os emails não coincidem.';
                errorMsgEmail.style.visibility = 'visible';
                errorMsgEmail.style.opacity = '1';
                document.getElementById("confirm-email-group").scrollIntoView({ behavior: "smooth" });
                isValid = false;
                setTimeout(() => {
                    errorMsgEmail.style.opacity = '0';
                    errorMsgEmail.style.visibility = 'hidden';
                    }, 5000);
            }

            // Verifica se as senhas coincidem
            if (password !== confirmPassword) {
                const errorMsgPassword = document.getElementById("password-error");
                errorMsgPassword.textContent = 'As senhas não coincidem.';
                errorMsgPassword.style.visibility = 'visible';
                errorMsgPassword.style.opacity = '1';
                document.getElementById("confirm-password-group").scrollIntoView({ behavior: "smooth" });
                isValid = false;
                setTimeout(() => {
                    errorMsgPassword.style.opacity = '0';
                    errorMsgPassword.style.visibility = 'hidden';
                    }, 5000);
            }

            // Se não for válido, impede o envio do formulário
            if (!isValid) {
                event.preventDefault();
            }
        });
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

