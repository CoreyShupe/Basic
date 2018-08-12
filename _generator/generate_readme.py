import json
import os

class Language:
  def __init__(self, name, d, project_sub):
    self.name = name
    self.d = d
    self.project_sub = project_sub

with open("readme.template.md") as f:
  readme = f.read().replace("\\n", "\n")

with open("readme.template.json") as f:
  data = json.load(f)

projects_json = sorted(data['projects'], key=lambda k: k['name'])
langs_json = sorted(data['languages'], key=lambda k: k['name'])

langs = list()

lang_string = ""
for sub in langs_json:
  langs.append(Language(sub['name'], sub['dir'], sub['project_sub']))
  lang_string += "(" + sub['name'] + ")[" + sub['dir'] + "]\n<br />\n"

project_string = ""
for sub in projects_json:
  name = sub['name']
  fname = name.replace(' ', '')
  d = sub['dir']
  adir = d.replace('_', '')
  part = "[" + name + "](project_descriptors/" + name.upper().replace(' ', '_') + ".md) ("
  for lang in langs:
    subbed = lang.project_sub.replace('{dir}', d).replace('{name}', fname).replace('{adir}', adir)
    part += "[" + lang.name + "](" + lang.d + "/" + d + "/" + subbed + ") "
  project_string += part + "\b)\n<br />\n"

readme = readme.replace("{languages}", lang_string).replace("{projects}", project_string)

rmf = open(os.path.abspath(os.path.join(os.path.realpath(os.path.dirname(__file__)), '..', 'README.md')), "w")
rmf.write(readme)
rmf.close()

print("Generated file README.md with contents:")
print(readme)