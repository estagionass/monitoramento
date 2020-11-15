let xmlHttp = new XMLHttpRequest()
let url = 'http://127.0.0.1:8080/api/v1/monitoramento'

function getIdClinicaTemperaturaEUmidade() {
xmlHttp.open('GET', url)

xmlHttp.onreadystatechange = () => {
    if(xmlHttp.readyState == 4 && xmlHttp.status == 200) {
        let dadosJSONText = xmlHttp.responseText
        let dadosJSONObj = JSON.parse(dadosJSONText)

        if(dadosJSONObj.idClinica == 1){
            document.getElementById('clinica').innerHTML = "Clínica Graças"
        } else {
            document.getElementById('clinica').innerHTML = "Clínica Derby"
        }
        
        document.getElementById('temperatura').innerHTML = dadosJSONObj.temperatura
        document.getElementById('umidade').innerHTML = dadosJSONObj.umidade
    }
}

xmlHttp.send()
}

window.setInterval('getIdClinicaTemperaturaEUmidade()', 15000)
