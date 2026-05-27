//função
function verificarReserva(){
    //variável
    let horario=document.getElementById("horario").value;
    //resultado
    let resultado=document.getElementById("resultado");
    //estrutura de decisão
    if(horario >=18 && horario<=23){
        resultado.innerHTML="Reserva disponível";
    }else{
        resultado.innerHTML="Restaurante Fechado";
    }
}