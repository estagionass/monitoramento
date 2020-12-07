// Percorre a url e recupera os parametros passados
var vars = [], hash;
var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
for (var i = 0; i < hashes.length; i++) {
    hash = hashes[i].split('=');
    vars.push(hash[0]);
    vars[hash[0]] = hash[1];
}

// Armazena o valor recebido pela URL
id = vars.id
dthrini = vars.dthrini
dthrfim = vars.dthrfim

// Cria um XMLHttpRequest responável por fazer requisições assíncronas (Ajax)
xmlHttp = new XMLHttpRequest()
// Url para obter o JSON dos dados com o id passado por parâmetro
dados = 'http://monitoramento.sa-east-1.elasticbeanstalk.com/api/v1/monitoramento/clinica?id=' + id

// Função responsável por receber e atualizar os dados no front-end
function getDados() {
    // Solicita um GET ao link definido acima
    xmlHttp.open('GET', dados)
    // Checa quando o estado tem alteração
    xmlHttp.onreadystatechange = () => {
        // Se o status do servidor for 4, que é quando ele já está retornando os dados e o status for 200 que é OK, execute o bloco a seguir
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
            // Recebe os dados em texto
            dadosJSONText = xmlHttp.responseText
            // Converte os dados em texto para JSON
            dadosJSONObj = JSON.parse(dadosJSONText)

            // Encontra o elemento nome_veterinario na página inicial e escreve o valor recebido do JSON
            document.getElementById('nome_clinica').innerHTML = dadosJSONObj.nomeClinica
            // Encontra o elemento nome_veterinario na página inicial e escreve o valor recebido do JSON
            document.getElementById('nome_veterinario').innerHTML = dadosJSONObj.nomeVeterinario
            // Encontra o elemento temperatura na página inicial e escreve o valor recebido do JSON
            document.getElementById('temperatura').innerHTML = dadosJSONObj.temperatura
            // Encontra o elemento umidade na página inicial e escreve o valor recebido do JSON
            document.getElementById('umidade').innerHTML = dadosJSONObj.umidade
            // Encontra o elemento dt_hr_dados na página inicial e escreve o valor recebido do JSON
            document.getElementById('dt_hr_dados').innerHTML = dadosJSONObj.dtHrDados
        }
    }
    // Envia a requisição
    xmlHttp.send()
}

// Cria um XMLHttpRequest responável por fazer requisições assíncronas (Ajax)
xmlHttp2 = new XMLHttpRequest()
// Url para obter a média da temperatura
media = 'http://monitoramento.sa-east-1.elasticbeanstalk.com/api/v1/monitoramento/media?id=' + id + '&dthrini=' + dthrini + '&dthrfim=' + dthrfim

function getMediaTemperatura() {

    // Solicita um GET ao link definido acima
    xmlHttp2.open('GET', media)

    // Checa quando o estado tem alteração
    xmlHttp2.onreadystatechange = () => {

        // Se o status do servidor for 4, que é quando ele já está retornando os dados e o status for 200 que é OK, execute o bloco a seguir
        if (xmlHttp2.readyState == 4 && xmlHttp2.status == 200) {
            document.getElementById('media_temperatura').innerHTML = Math.round(xmlHttp2.responseText)
        }
    }
    // Envia a requisição
    xmlHttp2.send()
}

// A cada um minuto chama as funções passadas abaixo
window.setInterval('getDados(), getMediaTemperatura()', 60000)
