/* eslint-disable */
export default function authRole() {
  let json: any = localStorage.getItem('role') ? localStorage.getItem('role') : '';
  let role: any | null = JSON.parse(json);
  if (role) {
    return role;
  } else {
    return {};
  }
}