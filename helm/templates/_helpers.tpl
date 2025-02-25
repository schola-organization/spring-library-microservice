{{ define "deployment_fullname" }}
{{ .Release.Name }}-deployment
{{ end }}

{{ define "container_fullname" }}
{{ .Release.Name }}-container
{{ end }}

{{ define "service_fullname" }}
{{ .Release.Name }}-service
{{ end }}