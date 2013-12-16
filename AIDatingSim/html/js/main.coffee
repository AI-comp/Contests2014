xmlDoc = null
init = ->
  xmlDoc = new XMLHttpRequest()
  xmlDoc.onreadystatechange = checkStateChange
  xmlDoc.open('get', '../txt/introduction.md', true)
  xmlDoc.send(null)

checkStateChange = ->
  if xmlDoc.readyState is 4 and (xmlDoc.status is 0 or xmlDoc.status is 200)
    txt = xmlDoc.responseText
    document.getElementById('md').innerHTML = markdown.toHTML(txt)
    console.log document.getElementsByTagName('body')[0].innerHTML

window.onload = init
