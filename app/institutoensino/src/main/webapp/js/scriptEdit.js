document.querySelectorAll('.botao-editar').forEach(button => {
    button.addEventListener('click', function() {
        const row = this.parentElement.parentElement; // Seleciona a linha
        const inputs = row.querySelectorAll('input, textarea'); // Seleciona todos os inputs e textareas na linha

        if (this.classList.contains("botao-editar")) {
            // Habilita edição nos campos
            inputs.forEach(input => input.disabled = false);
            
            // Troca o botão de "Editar" para "Salvar"
            this.textContent = "Salvar";
            this.classList.remove("botao-editar");
            this.classList.add("botao-salvar");
        } else {
            // Salva e desabilita a edição nos campos
            inputs.forEach(input => input.disabled = true);
            
            // Troca o botão de volta para "Editar"
            this.textContent = "Editar";
            this.classList.remove("botao-salvar");
            this.classList.add("botao-editar");
        }
    });
});
