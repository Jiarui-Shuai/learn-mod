[Console]::OutputEncoding = [System.Text.Encoding]::UTF8
gradle build
taskkill /f /im java.exe