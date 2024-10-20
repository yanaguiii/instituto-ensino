document.querySelector('button[type="submit"]').addEventListener('click', function (event) {
        const email = document.querySelector('input[type="email"]').value;
        const password = document.querySelector('input[type="password"]').value;
        const confirmEmail = document.querySelector('input[placeholder="Confirme seu email"]').value;
        const confirmPassword = document.querySelector('input[placeholder="Confirme sua senha"]').value;

        if (email !== confirmEmail) {
            alert('Os emails não coincidem.');
            event.preventDefault(); // Previne o envio do formulário
        }

        if (password !== confirmPassword) {
            alert('As senhas não coincidem.');
            event.preventDefault(); // Previne o envio do formulário
        }
    });
