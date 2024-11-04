// Função chamada ao clicar em uma matéria na sidebar
function carregarDadosMateria(materiaId) {
    fetch(`/dados-materia?materiaId=${materiaId}`)
        .then(response => response.json())
        .then(data => {
            // Atualizar as células da tabela com os dados retornados
            document.querySelector('.atividade').innerText = data.atividade;
            document.querySelector('.nota').innerText = data.nota;
            document.querySelector('.faltas').innerText = data.faltas;
            document.querySelector('.data').innerText = data.data;
            document.querySelector('.nota-final').innerText = data.notaFinal;
        })
        .catch(error => console.error('Erro ao carregar dados:', error));
}