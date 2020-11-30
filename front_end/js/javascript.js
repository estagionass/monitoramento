// Cria um XMLHttpRequest responável por fazer requisições assíncronas (Ajax)
xmlHttp = new XMLHttpRequest()
// Url para obter o JSON dos dados
dados = 'http://monitoramento.sa-east-1.elasticbeanstalk.com/api/v1/monitoramento'

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

            // Encontra o elemento temperatura na página inicial e escreve o valor recebido do JSON
            document.getElementById('temperatura').innerHTML = dadosJSONObj.temperatura
            // Encontra o elemento umidade na página inicial e escreve o valor recebido do JSON
            document.getElementById('umidade').innerHTML = dadosJSONObj.umidade
            // Encontra o elemento atualizacao na página inicial e escreve o valor recebido do JSON
            document.getElementById('atualizacao').innerHTML = dadosJSONObj.dtHrDados

            // Cria um XMLHttpRequest responável por fazer requisições assíncronas (Ajax)
            xmlHttp2 = new XMLHttpRequest()
            // Concatena o valor recebido do idClinica com a URL abaixo e faz a consulta da respectiva clínica no banco de dados
            clinica = 'http://monitoramento.sa-east-1.elasticbeanstalk.com/api/v1/monitoramento/clinica/' + dadosJSONObj.idClinica

            // Solicita um GET ao link definido acima
            xmlHttp2.open('GET', clinica)
            // Checa quando o estado tem alteração
            xmlHttp2.onreadystatechange = () => {
                // Se o status do servidor for 4, que é quando ele já está retornando os dados e o status for 200 que é OK, execute o bloco a seguir
                if (xmlHttp2.readyState == 4 && xmlHttp2.status == 200) {
                    // Recebe os dados em texto
                    dadosJSONText2 = xmlHttp2.responseText
                    // Converte os dados em texto para JSON
                    dadosJSONObj2 = JSON.parse(dadosJSONText2)

                    // Encontra o elemento nome_clinica na página inicial e escreve o valor recebido do JSON
                    document.getElementById('nome_clinica').innerHTML = dadosJSONObj2.nomeClinica
                }
            }
            // Envia a requisição
            xmlHttp2.send()
        }
    }
    // Envia a requisição
    xmlHttp.send()
}

// Cria um XMLHttpRequest responável por fazer requisições assíncronas (Ajax)
xmlHttp3 = new XMLHttpRequest()
// Url para obter a média da temperatura
media = 'http://monitoramento.sa-east-1.elasticbeanstalk.com/api/v1/monitoramento/media'

function getMediaTemperatura() {

    // Solicita um GET ao link definido acima
    xmlHttp3.open('GET', media)

    // Checa quando o estado tem alteração
    xmlHttp3.onreadystatechange = () => {

        // Se o status do servidor for 4, que é quando ele já está retornando os dados e o status for 200 que é OK, execute o bloco a seguir
        if (xmlHttp3.readyState == 4 && xmlHttp3.status == 200) {
            document.getElementById('media_temperatura').innerHTML = Math.round(xmlHttp3.responseText)
        }
    }
    // Envia a requisição
    xmlHttp3.send()
}

// A cada um minuto chama as funções passadas abaixo
window.setInterval('getDados(), getMediaTemperatura()', 60000)
