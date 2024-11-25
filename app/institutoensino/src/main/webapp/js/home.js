var swiper = new Swiper(".mySwiper", {
    slidesPerView: "auto",
    spaceBetween: 30,
    loop: true,
    centeredSlides: true,
    pagination: {
        el: ".swiper-pagination",
        clickable: true,
    },
    navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
    },
});

// Função para abrir o popup correspondente
function openPopup(popupId) {
    document.getElementById(popupId).style.display = "block";
}

// Fechar popup ao clicar no botão de fechar
document.querySelectorAll(".close").forEach(btn => {
    btn.addEventListener("click", function () {
        this.closest(".popup").style.display = "none";
    });
});

// Fechar popup ao clicar fora do conteúdo
window.addEventListener("click", function (event) {
    document.querySelectorAll(".popup").forEach(popup => {
        if (event.target === popup) {
            popup.style.display = "none";
        }
    });
});

function redirecionarMaterias(idUsuario) {
    fetch('verificarTipoUsuario?idUsuario=' + idUsuario)
        .then(response => response.text())
        .then(pagina => {
            window.location.href = pagina;
        })
        .catch(error => {
            console.error('Erro:', error);
            alert('Ocorreu um erro ao verificar o tipo de usuário');
        });
}

document.querySelector('.search-bar').addEventListener('submit', function(e) {
    e.preventDefault();
    const searchTerm = this.querySelector('input').value.toLowerCase();
    searchAndScrollToCourse(searchTerm);
});

function searchAndScrollToCourse(searchTerm) {
    const slides = swiper.slides;
    for (let i = 0; i < slides.length; i++) {
        const slideTitle = slides[i].querySelector('.slide-title').textContent.toLowerCase();
        if (slideTitle.includes(searchTerm)) {
            swiper.slideTo(i);
            return;
        }
    }
    alert('Curso não encontrado');
}

