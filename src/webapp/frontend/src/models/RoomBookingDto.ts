/* eslint-disable */
export class RoomBookingDto {
  public id?: string;
  public roomId?: string;
  public userId?: string;
  public date?: string;
  public time?: string;
  public comment?: string;

  constructor(init?: Partial<RoomBookingDto>) {
    Object.assign(this, init);
  }
}
