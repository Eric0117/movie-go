import axios from "axios"

const BASE_URL = "http://localhost:8080/api/v1/"

const API = axios.create({
    baseURL: BASE_URL,
    withCredentials: true,
    headers: {
        "Content-type": "application/json",
    },
})

API.interceptors.request.use(function (config) {
    const token = localStorage.getItem("token")

    // if (!token) {
    //     config.headers["accessToken"] = null
    //     config.headers["refreshToken"] = null
    //     return config
    // }
    if (config.headers && token) {
        const { accessToken, refreshToken } = JSON.parse(token)
        config.headers["Authorization"] = `Bearer ${accessToken}`
        config.headers["refreshToken"] = `Bearer ${refreshToken}`
        return config
    }
    return config
})

// API.interceptors.response.use(
//     function (response) {
//       return response;
//     },
//     async function (err) {
//       const originalConfig = err.config;

//       if (err.response && err.response.status === 401) {
//         const refreshToken = originalConfig.headers["refreshToken"];
//         try {
//           const data = await axios({
//             url: `refreshtoken담아 보낼 URL`,
//             method: "GET",
//             headers: {
//               Authorization: refreshToken,
//             },
//           });
//           if (data) {
//             localStorage.setItem(
//               "token",
//               JSON.stringify(data.data, ["accessToken", "refreshToken"])
//             );
//             return await Apis.request(originalConfig);
//           }
//         } catch (err) {
//           console.log("토큰 갱신 에러");
//         }
//         return Promise.reject(err);
//       }
//       return Promise.reject(err);
//     }
//   );

const getData = (url, params) => {
    return API.get(url, { params: params }).then((res) => res.data)
}

const postData = (url, data) => {
    return API.post(url, data).then((res) => res.data)
}

const putData = (url, data) => {
    return API.put(url, data).then((res) => res.data)
}

const deleteData = (url) => {
    return API.delete(url).then((res) => res.data)
}

export { getData, postData, putData, deleteData }
