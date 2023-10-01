<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Sign up Form</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="style.css" />
  </head>
  <body>
    <div class="container">
      <div class="row justify-content-center align-items-center" id="cc">
        <div class="col-md-6 px-5" id="singupform">
          <form action="insert" method="post" >
            <p class="text-center" id="heading">Register your self</p>

            <div class="my-2">
              <p class="m-0">Email</p>
              <input
                type="email"
                name="Email"
                id=""
                placeholder="Abhay@gmail.com"

                required
              />
            </div>
            <div class="my-2">
              <p class="m-0">Password</p>
              <input
                type="password"
                name="Password"
                id=""
                placeholder="must be at least 6 later"
                required
              />
            </div>

            <div  class="my-2">
              <table>
                <tbody>
                  <tr>
                    <td class="mx-2">First Name</td>
                    <td class="mx-2">last Name</td>
                  </tr>
                  <tr>
                    <td>
                      <input
                        type="text"
                        name="Firstname"
                        id=""
                        placeholder="Abhay"
                        class="me-2"
                        required
                      />
                    </td>
                    <td>
                      <input
                        type="text"
                        name="Lastname"
                        id=""
                        placeholder="Narvade"
                        class="ms-2"
                        required
                      />
                    </td>
                  </tr>
                  <tr>
                    <td colspan="2" class="text-center ">
                        <input type="submit" class="btn btn-primary my-2">
                    </td>
                  </tr>
                </tbody>
              </table>
            </div>
           
          </form>
        </div>
      </div>
    </div>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
