document.addEventListener("DOMContentLoaded", function() {
    // Seleciona o botão e o campo de texto
    const botaoEnviar = document.querySelector(".botao");
    const quadroAvisos = document.querySelector(".quadro-avisos");

    // Adiciona um evento de clique no botão
    botaoEnviar.addEventListener("click", function() {
        // Pega o conteúdo do quadro de avisos
        const avisoTexto = quadroAvisos.value;
        
        // Verifica se há texto para enviar
        if (avisoTexto.trim() !== "") {
            // Aqui você pode substituir pelo envio ao backend, se precisar
            console.log("Aviso enviado:", avisoTexto);

            // Limpa o campo após o envio (opcional)
            quadroAvisos.value = "";

            // Alerta de confirmação
            alert("Aviso enviado com sucesso!");
        } else {
            alert("Por favor, escreva algo no quadro de avisos antes de enviar.");
        }
    });
});
