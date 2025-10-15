@echo off
setlocal enabledelayedexpansion

:: Read GitHub repo URL from github_repo.txt
if not exist "github_repo.txt" (
    echo Missing file: github_repo.txt
    pause
    exit /b
)
set /p REPO_URL=<github_repo.txt

:: Check Git installation
where git >nul 2>nul
if errorlevel 1 (
    echo Git not found. Please install Git and try again.
    pause
    exit /b
)

:: Clean up everything except these files and the PROJET-TP folder
for /f "delims=" %%f in ('dir /a /b') do (
    if /i not "%%f"=="send.bat" if /i not "%%f"=="github_repo.txt" if /i not "%%f"=="PROJET-TP" (
        rd /s /q "%%f" 2>nul
        del /f /q "%%f" 2>nul
    )
)

:: Copy everything from PROJET-TP (including hidden + subfolders)
xcopy "PROJET-TP" ".\" /E /H /C /I /Y >nul
rmdir /s /q "PROJET-TP"

:: Initialize Git repo
if not exist ".git" git init

:: Remove all previous tracked files (in case some were deleted)
git rm -rf . >nul 2>nul

:: Add ALL files (including hidden)
git add -A

:: Commit all
git commit -m "Replace all content with PROJET-TP" >nul 2>nul

:: Rename branch
git branch -M main

:: Set remote
git remote remove origin >nul 2>nul
git remote add origin %REPO_URL%

:: Push (force overwrite)
git push origin main --force

echo.
echo ✅ Done! All contents from PROJET-TP uploaded successfully.
pause
