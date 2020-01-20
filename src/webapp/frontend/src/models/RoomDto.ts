/* eslint-disable */
export class RoomDto {
  public id?: string;
  public floor?: string;
  public name?: string;
  public personNumber?: string;
  public roomFeatures?: string;
  public img?: string;

  constructor(init?: Partial<RoomDto>) {
    Object.assign(this, init);
  }
}
