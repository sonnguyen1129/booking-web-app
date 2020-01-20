/* eslint-disable */
export default function authHeader() {
  let json: any = localStorage.getItem('token') ? localStorage.getItem('token') : '';
  let token: any | null = JSON.parse(json);
  if (token) {
    return { Authorization: 'Bearer ' + token };
  } else {
    return {};
  }
}