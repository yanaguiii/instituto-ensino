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

