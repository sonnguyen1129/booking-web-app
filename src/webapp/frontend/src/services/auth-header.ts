/* eslint-disable */
export default function authHeader() {
  let json: any = localStorage.getItem('auth') ? localStorage.getItem('auth') : '';
  let token: any | null = JSON.parse(json);
  if (token) {
    return { Authorization: 'Bearer ' + token.token };
  } else {
    return {};
  }
}