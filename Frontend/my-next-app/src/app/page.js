<<<<<<< HEAD
"use client";

import * as React from 'react';
import Image from 'next/image'
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import Checkbox from '@mui/material/Checkbox';
import { useState } from 'react';
import axios from 'axios';
import Link from 'next/Link'

const label = { inputProps: { 'aria-label': 'Checkbox demo' } };

export default function LoginPage() {

    const apiUrl = process.env.API_URL;

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [usernameError, setUsernameError] = useState('');
    const [passwordError, setPasswordError] = useState('');
    const [loginError, setLoginError] = useState('');

    const handleLogin = async () => {
        let hasError = false;
        if (username === '') {
            setUsernameError('Please enter username');
            hasError = true;
        } else {
            setUsernameError('');
        }
        if (password === '') {
            setPasswordError('Please enter password');
            hasError = true;
        } else {
            setPasswordError('');
        }
        if (!hasError) {
            try {
                const response = await axios.post(`http://34.221.147.150:8081/api/v1/auth/login`, {
                    "email" : username,
                    "password" :password
                });

                if (response.status === 200) {
                    <Link href={'/success'}></Link>
                }
            } catch (error) {
                if (error.response && error.response.status === 401) {
                    console.error('Error response:', error.response);
                    setLoginError('Invalid username or password');
                } else {
                    setLoginError('An error occurred. Please try again.');
                }
            }
        }
    };

    return (
        <main>
            <div className="grid items-center grid-cols-1 md:grid-cols-2 lg:grid-cols-2">
                <div className='md:ms-28 ms-5'>
                    <img className='md:ms-20 ms-5 mb-10 w-3/4 md:w-auto' src="/skillcapital.png" alt="Logo"></img>
                    <div className='border-inherit border-2 rounded-md shadow-lg p-6 w-full md:w-3/4 mt-5 md:ms-10'>
                        <label className='font-normal text-sm'>User Name</label>
                        <TextField 
                            fullWidth
                            id="username"
                            value={username}
                            onChange={(e) => setUsername(e.target.value)}
                        />
                        {usernameError && <div style={{ color: '#E22449',fontSize:'15px' }}>{usernameError}</div>}
                        <label className='font-normal text-sm'>Password</label>
                        <TextField
                            type="password"
                            fullWidth
                            id="password"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                        />
                        {passwordError && <div style={{ color: '#E22449',fontSize:'15px' }}>{passwordError}</div>}
                        <Button
                            fullWidth
                            variant="contained"
                            className='mt-10 mb-5 bg-gradient-to-r from-orange-300 to-pink-500'
                            onClick={handleLogin}
                        >
                            Login
                        </Button>
                        {loginError && <div style={{ color: '#E22449', fontSize: '15px' }}>{loginError}</div>}
                        <div className='flex items-center'>
                            <Checkbox {...label} />
                            <span className='text-slate-600'>Remember Me</span>
                        </div>
                        <p className=' text-slate-600 text-center mt-20'>©2024, All rights reserved</p>
                    </div>
                </div>
                <div className='w-1.9/3 left-[50%] mt-10'>
                    <div className='mt-12 ms-15'>
                        <h1 className='text-3xl font-bold w-3/4 text-center text-customBlue ps-10 ms-4'>Seamlessly manage all learner data in a unified platform.</h1>
                        <p className='text-lg w-3/4 text-center font-light text-customBlue ms-10 lg:ms-14'>Centralize customer data effortlessly. Streamline communication, sales, and support for seamless growth.</p>
                    </div>
                    <img className='mt-10' src="/pinkcrm.png"></img>
                </div>
            </div>
        </main>
    );
=======
import Image from "next/image";

export default function Home() {
  return (
    <main className="flex min-h-screen flex-col items-center justify-between p-24">
      <div className="z-10 max-w-5xl w-full items-center justify-between font-mono text-sm lg:flex">
        <p className="fixed left-0 top-0 flex w-full justify-center border-b border-gray-300 bg-gradient-to-b from-zinc-200 pb-6 pt-8 backdrop-blur-2xl dark:border-neutral-800 dark:bg-zinc-800/30 dark:from-inherit lg:static lg:w-auto  lg:rounded-xl lg:border lg:bg-gray-200 lg:p-4 lg:dark:bg-zinc-800/30">
          Get started by editing&nbsp;
          <code className="font-mono font-bold">src/app/page.js</code>
        </p>
        <div className="fixed bottom-0 left-0 flex h-48 w-full items-end justify-center bg-gradient-to-t from-white via-white dark:from-black dark:via-black lg:static lg:h-auto lg:w-auto lg:bg-none">
          <a
            className="pointer-events-none flex place-items-center gap-2 p-8 lg:pointer-events-auto lg:p-0"
            href="https://vercel.com?utm_source=create-next-app&utm_medium=appdir-template&utm_campaign=create-next-app"
            target="_blank"
            rel="noopener noreferrer"
          >
            By{" "}
            <Image
              src="/vercel.svg"
              alt="Vercel Logo"
              className="dark:invert"
              width={100}
              height={24}
              priority
            />
          </a>
        </div>
      </div>

      <div className="relative flex place-items-center before:absolute before:h-[300px] before:w-full sm:before:w-[480px] before:-translate-x-1/2 before:rounded-full before:bg-gradient-radial before:from-white before:to-transparent before:blur-2xl before:content-[''] after:absolute after:-z-20 after:h-[180px] after:w-full sm:after:w-[240px] after:translate-x-1/3 after:bg-gradient-conic after:from-sky-200 after:via-blue-200 after:blur-2xl after:content-[''] before:dark:bg-gradient-to-br before:dark:from-transparent before:dark:to-blue-700 before:dark:opacity-10 after:dark:from-sky-900 after:dark:via-[#0141ff] after:dark:opacity-40 before:lg:h-[360px] z-[-1]">
        <Image
          className="relative dark:drop-shadow-[0_0_0.3rem_#ffffff70] dark:invert"
          src="/next.svg"
          alt="Next.js Logo"
          width={180}
          height={37}
          priority
        />
      </div>

      <div className="mb-32 grid text-center lg:max-w-5xl lg:w-full lg:mb-0 lg:grid-cols-4 lg:text-left">
        <a
          href="https://nextjs.org/docs?utm_source=create-next-app&utm_medium=appdir-template&utm_campaign=create-next-app"
          className="group rounded-lg border border-transparent px-5 py-4 transition-colors hover:border-gray-300 hover:bg-gray-100 hover:dark:border-neutral-700 hover:dark:bg-neutral-800/30"
          target="_blank"
          rel="noopener noreferrer"
        >
          <h2 className={`mb-3 text-2xl font-semibold`}>
            Docs{" "}
            <span className="inline-block transition-transform group-hover:translate-x-1 motion-reduce:transform-none">
              -&gt;
            </span>
          </h2>
          <p className={`m-0 max-w-[30ch] text-sm opacity-50`}>
            Find in-depth information about Next.js features and API.
          </p>
        </a>

        <a
          href="https://nextjs.org/learn?utm_source=create-next-app&utm_medium=appdir-template-tw&utm_campaign=create-next-app"
          className="group rounded-lg border border-transparent px-5 py-4 transition-colors hover:border-gray-300 hover:bg-gray-100 hover:dark:border-neutral-700 hover:dark:bg-neutral-800 hover:dark:bg-opacity-30"
          target="_blank"
          rel="noopener noreferrer"
        >
          <h2 className={`mb-3 text-2xl font-semibold`}>
            Learn{" "}
            <span className="inline-block transition-transform group-hover:translate-x-1 motion-reduce:transform-none">
              -&gt;
            </span>
          </h2>
          <p className={`m-0 max-w-[30ch] text-sm opacity-50`}>
            Learn about Next.js in an interactive course with&nbsp;quizzes!
          </p>
        </a>

        <a
          href="https://vercel.com/templates?framework=next.js&utm_source=create-next-app&utm_medium=appdir-template&utm_campaign=create-next-app"
          className="group rounded-lg border border-transparent px-5 py-4 transition-colors hover:border-gray-300 hover:bg-gray-100 hover:dark:border-neutral-700 hover:dark:bg-neutral-800/30"
          target="_blank"
          rel="noopener noreferrer"
        >
          <h2 className={`mb-3 text-2xl font-semibold`}>
            Templates{" "}
            <span className="inline-block transition-transform group-hover:translate-x-1 motion-reduce:transform-none">
              -&gt;
            </span>
          </h2>
          <p className={`m-0 max-w-[30ch] text-sm opacity-50`}>
            Explore starter templates for Next.js.
          </p>
        </a>

        <a
          href="https://vercel.com/new?utm_source=create-next-app&utm_medium=appdir-template&utm_campaign=create-next-app"
          className="group rounded-lg border border-transparent px-5 py-4 transition-colors hover:border-gray-300 hover:bg-gray-100 hover:dark:border-neutral-700 hover:dark:bg-neutral-800/30"
          target="_blank"
          rel="noopener noreferrer"
        >
          <h2 className={`mb-3 text-2xl font-semibold`}>
            Deploy{" "}
            <span className="inline-block transition-transform group-hover:translate-x-1 motion-reduce:transform-none">
              -&gt;
            </span>
          </h2>
          <p className={`m-0 max-w-[30ch] text-sm opacity-50 text-balance`}>
            Instantly deploy your Next.js site to a shareable URL with Vercel.
          </p>
        </a>
      </div>
    </main>
  );
>>>>>>> b1e37e66d42f29a233158227b505c0da40ba8843
}
