$(document).ready(function () {
    $('.btn-modificar').click(function () {
        var row = $(this).closest('tr');
        row.find('.text-faltas, .text-nota').addClass('hidden');
        row.find('.input-faltas, .input-nota').removeClass('hidden');
        $(this).addClass('hidden');
        row.find('.btn-salvar').removeClass('hidden');
    });

    $('.btn-salvar').click(function () {
        var row = $(this).closest('tr');
        var idAluno = row.find('input[name="aluno-materia-id-aluno"]').val();
        var idMateria = row.find('input[name="aluno-materia-id-materia"]').val();
        var faltas = row.find('.input-faltas').val();
        var nota = row.find('.input-nota').val();

        $.ajax({
            url: 'atualizar-aluno-materia',
            method: 'POST',
            data: {
                'aluno-materia-id-aluno': idAluno,
                'aluno-materia-id-materia': idMateria,
                'aluno-materia-faltas': faltas,
                'aluno-materia-nota': nota
            },
            success: function (response) {
                console.log('Resposta completa:', response);
                if (response === "success") {
                    row.find('.text-faltas').text(faltas).removeClass('hidden');
                    row.find('.text-nota').text(nota).removeClass('hidden');
                    row.find('.input-faltas, .input-nota').addClass('hidden');
                    row.find('.btn-salvar').addClass('hidden');
                    row.find('.btn-modificar').removeClass('hidden');
                    alert('Alterações salvas com sucesso!');
                } else {
                    alert('Erro ao salvar as alterações: ' + response);
                }
            },
            error: function () {
                alert('Erro ao salvar as alterações.');
            }
        });
    });
});

document.querySelectorAll('#nav-content .nav-item a').forEach(link => {
    link.addEventListener('click', function (e) {
        e.preventDefault();
        const targetId = this.getAttribute('href').substring(1);
        const targetElement = document.getElementById(targetId);
        if (targetElement) {
            targetElement.scrollIntoView({behavior: 'smooth'});
        }
    });
});
