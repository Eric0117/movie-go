import * as Yup from "yup"
import { useState } from "react"
import { useNavigate } from "react-router-dom"
// form
import { useForm } from "react-hook-form"
import { yupResolver } from "@hookform/resolvers/yup"
// @mui
import { Link, Stack, IconButton, InputAdornment } from "@mui/material"
import { LoadingButton } from "@mui/lab"
// components
import Iconify from "../../../components/Iconify"
import {
    FormProvider,
    RHFTextField,
    RHFCheckbox,
} from "../../../components/hook-form"
import authState, { isLoggedInState } from "../../../store/authStore"
import { useSetRecoilState } from "recoil"
import { postData } from "../../../api/apiClient"
import { useMutation } from "@tanstack/react-query"

// ---------------------------------------------------------------------- https://tanstack.com/query/v4/docs/guides/updates-from-mutation-responses

export default function LoginForm() {
    const navigate = useNavigate()
    const setAuth = useSetRecoilState(authState)
    const setIsLoggedIn = useSetRecoilState(isLoggedInState)
    const [showPassword, setShowPassword] = useState(false)

    const mutationLogin = useMutation((data) => postData("auth/signin", data))

    const LoginSchema = Yup.object().shape({
        email: Yup.string()
            .email("올바른 이메일 형식을 입력해주세요.")
            .required("이메일을 입력해주세요."),
        password: Yup.string().required("비밀번호를 입력해주세요."),
    })

    const defaultValues = {
        email: "",
        password: "",
        remember: true,
    }

    const methods = useForm({
        resolver: yupResolver(LoginSchema),
        defaultValues,
    })

    const {
        handleSubmit,
        formState: { isSubmitting },
    } = methods

    const onSubmit = async () => {
        console.log(methods.getValues("email"))
        const data = {
            usernameOrEmail: methods.getValues("email"),
            password: methods.getValues("password"),
        }
        mutationLogin.mutateAsync(data).then((res) => {
            console.log(res.data)
        })
        // setAuth({
        //     userName: "hello",
        //     email: "poepoe@asas.com",
        //     photoURL:
        //         "https://i.pinimg.com/564x/d0/08/4e/d0084e4287bc6dc8e15f4f4bc43f5c31.jpg",
        // })
        // setIsLoggedIn(true)
        // navigate("/", { replace: true })
    }

    return (
        <FormProvider methods={methods} onSubmit={handleSubmit(onSubmit)}>
            <Stack spacing={3}>
                <RHFTextField name="email" label="Email address" />

                <RHFTextField
                    name="password"
                    label="Password"
                    type={showPassword ? "text" : "password"}
                    InputProps={{
                        endAdornment: (
                            <InputAdornment position="end">
                                <IconButton
                                    onClick={() =>
                                        setShowPassword(!showPassword)
                                    }
                                    edge="end"
                                >
                                    <Iconify
                                        icon={
                                            showPassword
                                                ? "eva:eye-fill"
                                                : "eva:eye-off-fill"
                                        }
                                    />
                                </IconButton>
                            </InputAdornment>
                        ),
                    }}
                />
            </Stack>

            <Stack
                direction="row"
                alignItems="center"
                justifyContent="space-between"
                sx={{ my: 2 }}
            >
                <RHFCheckbox name="remember" label="Remember me" />
                <Link variant="subtitle2" underline="hover">
                    비밀번호를 잊으셨나요?
                </Link>
            </Stack>

            <LoadingButton
                fullWidth
                size="large"
                type="submit"
                variant="contained"
                loading={isSubmitting}
            >
                로그인
            </LoadingButton>
        </FormProvider>
    )
}
