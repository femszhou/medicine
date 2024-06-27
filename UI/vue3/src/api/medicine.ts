import request from "@/utils/request"

//定义类型
type First<T>={
    config:T
    data:T
    headers:T
    request:T
    status:number
    statusText:string
}
type Common<T>={
    code:number
    data:T
    msg:string
}

type char<T>={
    rows:T
    total:number
}

export type Menu={
    medicineNo:number
    medicineName:string
    medicineMode:string
    medicineEfficacy:string
    medicinePrice:number
    medicineCount:number
    medicineImage:string
}

//获取所有有药物信息
export const getMedicine=(page: number, pageSize: number)=>{
    return request<Common<char<Menu[]>>>({
        method:'GET',
        url:"/medicine",
        params: {
            page,
            pageSize
          }
    })
}

export const getMedicineByName=(medicineName:string)=>{
    return request<Common<char<Menu[]>>>({
        method:'GET',
        url:"/medicine",
        params: {
            medicineName
          }
    })
}

export const getMedicineByNo=(medicineNo:number)=>{
    return request<Common<char<Menu[]>>>({
        method:'GET',
        url:"/medicine",
        params: {
            medicineNo
          }
    })
}


//按序号查找
export const find =(medicineNo:number)=>{
    return request({
        method:"GET",
        url:`/medicine/${medicineNo}`,
    })
}
//添加药物信息

export type addMenu = Pick<Menu,"medicineName"|"medicineMode"|"medicineMode"|"medicineEfficacy"|"medicinePrice"|"medicineCount">

export const addmedicine = (addInfo:addMenu)=>{
    return request({
        method:"POST",
        url:"/medicine",
        data:addInfo,
    })
}

//删除药物信息
export const delMenu =(medicineNo:number)=>{
    return request({
        method:"DELETE",
        url:`/medicine/${medicineNo}`,
    })
}

//修改药物信息

export type putMenu = Pick<Menu,"medicineNo"|"medicineName"|"medicineMode"|"medicineMode"|"medicineEfficacy"|"medicinePrice"|"medicineCount">
export const getmedicine = ((medicineNo:string) =>{
    return request<Common<char<Menu[]>>>({
        method:'GET',
        url:'/medicine',
        params:{
            medicineNo,
        }
    })
})

export const putmedicine = ((putInfo:putMenu) =>{
    return request<Common<char<Menu[]>>>({
        method:'PUT',
        url:'/medicine',
        data:putInfo
    })
})