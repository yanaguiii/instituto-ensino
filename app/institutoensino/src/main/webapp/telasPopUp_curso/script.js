// Abrir popup
document.getElementById("openPopupBtn").addEventListener("click", function() {
    document.getElementById("popup").style.display = "block";
});

// Fechar popup
document.getElementById("closePopupBtn").addEventListener("click", function() {
    document.getElementById("popup").style.display = "none";
});

// Fechar popup clicando fora do conteúdo
window.addEventListener("click", function(event) {
    if (event.target == document.getElementById("popup")) {
        document.getElementById("popup").style.display = "none";
    }
});
