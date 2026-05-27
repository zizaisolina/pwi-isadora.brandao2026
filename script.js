function verificarPromocao(){
    let dia=document.getElementById("dia").value;
    let resultado=document.getElementById("resultado");
    //Deixa tudo minúsculo
    dia=dia.toLowerCase();
    //estrutura switch case
    switch(dia){
        case "segunda":
            resultado.innerHTML="Pizza em dobro";
            break;
        case "terça":
            resultado.innerHTML="Refrigerante grátis";
            break;
        case "quarta":
            resultado.innerHTML="Rodízio com desconto";
            break;
        case "quinta":
            resultado.innerHTML="Sobremesa grátis";
            break;
        case "sexta":
            resultado.innerHTML="Caipirinha grátis";
            break;
        case "sábado":
            resultado.innerHTML="Menu Especial";
            break;
        case "domingo":
            resultado.innerHTML="Restaurante Fechado";
            break;
        default:
            resultado.innerHTML="Digite um dia válido";
    }
}