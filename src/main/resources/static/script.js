const API_BASE_URL = 'http://localhost:8080/api';

const formCriarPessoa = document.getElementById('form-criar-pessoa');
const inputNomePessoa = document.getElementById('input-nome-pessoa');
const listaPessoas = document.getElementById('lista-pessoas');

async function listarPessoas() {
    try {
        const response = await fetch(`${API_BASE_URL}/pessoas`);
        if (!response.ok) {
            throw new Error('Erro ao buscar pessoas');
        }
        const data = await response.json();

        listaPessoas.innerHTML = '';

        if (data.pessoas.length === 0) {
            listaPessoas.innerHTML = '<li>Nenhuma pessoa cadastrada.</li>';
            return;
        }

        data.pessoas.forEach(pessoa => {
            const li = document.createElement('li');
            li.textContent = `ID: ${pessoa.id} - Nome: ${pessoa.nome}`;
            listaPessoas.appendChild(li);
        });

    } catch (error) {
        console.error('Falha na requisição:', error);
        listaPessoas.innerHTML = '<li>Erro ao carregar a lista.</li>';
    }
}

async function criarPessoa(event) {

    event.preventDefault();

    const nome = inputNomePessoa.value;
    if (!nome) {
        alert('Por favor, digite um nome.');
        return;
    }

    try {
        const response = await fetch(`${API_BASE_URL}/pessoas`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ nome: nome }),
        });

        if (!response.ok) {
            throw new Error('Erro ao criar pessoa');
        }

        inputNomePessoa.value = '';

        await listarPessoas();

    } catch (error) {
        console.error('Falha na criação:', error);
        alert('Não foi possível criar a pessoa.');
    }
}
formCriarPessoa.addEventListener('submit', criarPessoa);

document.addEventListener('DOMContentLoaded', listarPessoas);