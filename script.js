document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("formProduto");

    form.addEventListener("submit", function (e) {
        const nome = document.getElementById("nome").value.trim();
        const preco = parseFloat(document.getElementById("preco").value);
        const quantidade = parseInt(document.getElementById("quantidade").value);

        let mensagensErro = [];

        if (nome === "") {
            mensagensErro.push("O nome do produto é obrigatório.");
        }

        if (isNaN(preco) || preco <= 0) {
            mensagensErro.push("O preço deve ser maior que zero.");
        }

        if (isNaN(quantidade) || quantidade < 0) {
            mensagensErro.push("A quantidade deve ser zero ou maior.");
        }

        if (mensagensErro.length > 0) {
            e.preventDefault(); // impede envio do formulário
            alert(mensagensErro.join("\n"));
        }
    });
});